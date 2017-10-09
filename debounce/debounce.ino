const int buttonPin = 2;
int presses = 0;

unsigned long lastDebounceTime = 0;
unsigned long debounceDelay = 100;

void buttonPressed() {
//  Serial.println("Interrupt");
  unsigned long now = millis();
  if (now - lastDebounceTime > debounceDelay) {
    presses += 1;
    Serial.println("Pressed");
  }
  lastDebounceTime = now;
}

void setup() {
  pinMode(buttonPin, INPUT_PULLUP);

  // Interrupts can happen on "edges" of signals.  
  // Three edge types are supported: CHANGE, RISING, and FALLING 
  attachInterrupt(digitalPinToInterrupt(buttonPin), buttonPressed, FALLING);
  Serial.begin(9600);
}

void loop() {
  Serial.println(presses);
  delay(1000);
}

