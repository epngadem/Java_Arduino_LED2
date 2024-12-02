int ledPin = 13; // Broche de la LED

void setup() {
  Serial.begin(9600); // Initialise la communication série
  pinMode(ledPin, OUTPUT); // Définit la broche LED comme sortie
  digitalWrite(ledPin, LOW); // Assurez-vous que la LED est éteinte au démarrage
}

void loop() {
  if (Serial.available()) { // Si des données sont disponibles
    char command = Serial.read(); // Lire la commande
    if (command == '1') {
      digitalWrite(ledPin, HIGH); // Allumer la LED
      Serial.println("LED ON");
    } else if (command == '0') {
      digitalWrite(ledPin, LOW); // Éteindre la LED
      Serial.println("LED OFF");
    }
  }
}


