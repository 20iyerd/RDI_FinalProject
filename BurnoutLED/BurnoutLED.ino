#include <Adafruit_NeoPixel.h>

#define pin 4
#define stripLength 100

int newR;
int newG;
int newB;
uint32_t THBlue;
uint32_t THGold;
int t = 10;

Adafruit_NeoPixel strip1(stripLength, pin, NEO_RGB);

void setup() {
  Serial.begin(9600);
  strip1.begin();
  THBlue = strip1.Color(100, 15, 250);
  THGold = strip1.Color(200, 250, 5);
  setStripColor(THBlue);
}

void loop() {
  
  fade(100, 125, 3, t, 15);
  multiShift(t, 20);
  fade(50, 8, 125, t, 15);
  multiShift(t, 15);


}


void fade(uint8_t R, uint8_t G, uint8_t B, int switchTime, int fadeLength)  {
  uint32_t oldColor = strip1.getPixelColor(0);
  int oldR = getRed(oldColor);
  int oldG = getGreen(oldColor);
  int oldB = getBlue(oldColor);
  int changeR = (abs(R - oldR) / fadeLength);
  int changeG = (abs(G - oldG) / fadeLength);
  int changeB = (abs(B - oldB) / fadeLength);
  
  for(int i=1; i<=(fadeLength); i++) {
    if(R > oldR)  {
      newR = oldR + (changeR * i);
    } else  if(R < oldR)  {
      newR = oldR - (changeR * i);
    } else  if(R = oldR)  {
      newR = oldR;
    }
    if(G > oldG)  {
      newG = oldG + (changeG * i);
    } else  if(G < oldG)  {
      newG = oldG - (changeG * i);
    } else  if(G = oldG)  {
      newG = oldG;
    }
    if(B > oldB)  {
      newB = oldB + (changeB * i);
    } else  if(B < oldB)  {
      newB = oldB - (changeB * i);
    } else  if(B = oldB)  {
      newB = oldB;
    }
    singleColorShift();
    strip1.setPixelColor(0, newR, newG, newB);
    strip1.show();
    delay(switchTime);
  }
  strip1.setPixelColor(0, R, G, B);
  strip1.show();
}

void singleColorShift() {
  for(int i=stripLength; i>0; i--) {
    uint32_t prevColor = strip1.getPixelColor((i-1));
    int Ra = getRed(prevColor);
    int Ga = getGreen(prevColor);
    int Ba = getBlue(prevColor);
    strip1.setPixelColor(i, Ra, Ga, Ba);
  }
}

void multiShift(int shiftTime, int shiftLength) {
  for(int i=0; i < shiftLength; i++)  {
    singleColorShift();
    strip1.show();
    delay(shiftTime);
  }
}

void setStripColor(uint8_t R, uint8_t G, uint8_t B) {
  for(int i=0; i<strip1.numPixels(); i++)  {
    strip1.setPixelColor(i, R, G, B);
  }
  strip1.show();
}

void setStripColor(uint32_t color)  {
  int R = getRed(color);
  int G = getGreen(color);
  int B = getBlue(color);
  for(int i=0; i<strip1.numPixels(); i++)  {
    strip1.setPixelColor(i, R, G, B);
  }
  strip1.show();
  
}


/*
 * returns the red value from an RGB int
 */
uint8_t getRed(uint32_t c) {
    return c>>16;
}

/*
 * returns the green value from an RGB int
 */
uint8_t getGreen(uint32_t c) {
    return c>>8;
}

/*
 * returns the blue value from an RGB int
 */
uint8_t getBlue(uint32_t c) {
    return c;
}
