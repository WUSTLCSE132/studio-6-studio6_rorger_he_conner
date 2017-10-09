void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
}

typedef union {
  unsigned long i;
  float f;
 } u;

void loop() {
  // put your main code here, to run repeatedly:
  for (int i = 0; i < 360; i++) {
    Serial.write((i >> 8) & 0xFF);
    Serial.write(i & 0xFF);
    delay(50);
  }
//  for (float f = 1; f < 10000000000; f += 2.5) {
//    u u1;
//    u1.f = f;
//    unsigned long i = u1.i;
//    Serial.write((i >> 24) & 0xFF);
//    Serial.write((i >> 16) & 0xFF);
//    Serial.write((i >> 8) & 0xFF);
//    Serial.write(i & 0xFF);
//    delay(50);
//  }
  delay(10000000);
}
