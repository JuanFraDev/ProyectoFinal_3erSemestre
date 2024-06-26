#include "HX711.h"
#include <Wire.h>
#include <Adafruit_GFX.h>      //Liberia para gráficos
#include <Adafruit_SSD1306.h>  //Liberia para Oleds monocromáticos basados ​​en controladores SSD1306
/*Se declara el pin de reset, este es requerido por el constructor de la librería SSD1306
 *para definir el tipo de OLED y la comunicación I2C en los (pines SDA, SCL)*/
#define OLED_RESET 13
#define LOADCELL_DOUT_PIN A0  //pin DT del modulo HX711 ira conectado al pin A0 de arduino.
#define LOADCELL_SCK_PIN A1   //pin SCK del modulo HX711 ira conectado al pin A1 de arduino.
Adafruit_SSD1306 display(OLED_RESET);
/*Se define una condición para saber si en la librería esta definida la altura de 32 de lo contrario 
 *no dejara compilar el código hasta que se cambie la altura correcta desde la librería*/
#if (SSD1306_LCDHEIGHT != 32)
#error("Altura incorrecta, cambie en la librería de Adafruit_SSD1306.h!");
#endif

HX711 scale;
float calibration_factor = -501;  //-501 funciona para mi celda de carga de 5 kgs
double peso;
double precio;
char dato = '0';

const unsigned char cora[] PROGMEM = {
  0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
  0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
  0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
  0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
  0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
  0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x0f, 0xff, 0x00,
  0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x3f, 0xff, 0x80,
  0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7f, 0xff, 0x00,
  0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0xff, 0xff, 0x00,
  0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0xff, 0xfe, 0x00,
  0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0xff, 0xf8, 0x00,
  0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0xf8, 0x00, 0x00,
  0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0xf0, 0x00, 0x00,
  0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0xf8, 0x00, 0x00,
  0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0xff, 0xfc, 0x00,
  0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0xff, 0xff, 0x00,
  0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0xff, 0xff, 0x80,
  0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x7f, 0xff, 0xc0,
  0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x3f, 0xff, 0xc0,
  0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x0f, 0xc0,
  0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x0f, 0xfc, 0x07, 0xe0,
  0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x0c, 0x06, 0x07, 0xe0,
  0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x0c, 0x03, 0x0f, 0xc0,
  0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x04, 0x01, 0xff, 0xc0,
  0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x06, 0x00, 0xff, 0xc0,
  0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x03, 0x00, 0x7f, 0x80,
  0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0x80, 0x7f, 0x00,
  0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0xff, 0xfc, 0x00,
  0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
  0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
  0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
  0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00
};

void setup() {
  Serial.begin(9600);
  /* Se inicia la comunicación I2C en la direccion 0x3C para la pantalla oled 128x32*/
  display.begin(SSD1306_SWITCHCAPVCC, 0x3C);
  scale.begin(LOADCELL_DOUT_PIN, LOADCELL_SCK_PIN);
  scale.set_scale();
  scale.tare();  //Reset the scale to 0
}

void loop() {
  /*Se manda a llamar la función leer_oled para ejecutar su contenido*/
  logo_main();
  if(Serial.available() > 0){
    dato = Serial.read();
    if(dato == '1'){
      peso = recoger_Peso();
      calibrando_fin();
      peso = recoger_Peso();
      Serial.println(peso);
      cargando_fin();
      cargando_fin();
      String datoRecibido = Serial.readStringUntil('\n');
      precio = atof(datoRecibido.c_str());
      mostrar_Precio(peso, precio);
      dato == '0';
      delay(10000);
    }
  }
}

void logo_main() {
  display.clearDisplay();                      //Borra el buffer
  display.drawBitmap(0, 0, cora, 128, 32, 1);  //Se define la imagen su posición
  display.setTextSize(1);                      //Establece el tamaño de fuente, admite tamaños de 1 a 8
  display.setTextColor(WHITE);                 //Establece el color
  display.setCursor(7, 10);                    //Establecer las coordenadas para mostrar la posición del texto
  display.println("SUPER TIENDAS");
  display.display();
}

void calibrando_fin() {
  display.clearDisplay();
  calibrando_1();
  delay(700);
  calibrando_2();
  delay(700);
  calibrando_3();
  delay(700);
  colocar();
  delay(3000);
}

void cargando_fin() {
  display.clearDisplay();
  cargando_1();
  delay(700);
  cargando_2();
  delay(700);
  cargando_3();
  delay(700);
}

float recoger_Peso() {
  float aux;
  scale.set_scale(calibration_factor);
  for (int i = 0; i < 5; i++) {
    aux = scale.get_units();
  }
  return aux;
}

void mostrar_Precio(double peso, double precio) {
  display.clearDisplay();
  display.drawBitmap(0, 0, cora, 128, 32, 1);
  display.setTextSize(1);  //Establece el tamaño de fuente, admite tamaños de 1 a 8
  display.setTextColor(WHITE);
  display.setCursor(5, 5);  //Establecer las coordenadas para mostrar la posición del texto
  display.print("Peso: ");
  display.print(peso);
  display.println(" gr");
  display.setCursor(5, 15);
  display.print("Precio: $");
  display.println(precio);
  display.display();
}

void cargando_1() {
  display.clearDisplay();
  display.setTextSize(1);  //Establece el tamaño de fuente, admite tamaños de 1 a 8
  display.setTextColor(WHITE);
  display.setCursor(35, 10);  //Establecer las coordenadas para mostrar la posición del texto
  display.println("CARGANDO.");
  display.display();
}
void cargando_2() {
  display.clearDisplay();
  display.setTextSize(1);  //Establece el tamaño de fuente, admite tamaños de 1 a 8
  display.setTextColor(WHITE);
  display.setCursor(35, 10);  //Establecer las coordenadas para mostrar la posición del texto
  display.println("CARGANDO..");
  display.display();
}
void cargando_3() {
  display.clearDisplay();
  display.setTextSize(1);  //Establece el tamaño de fuente, admite tamaños de 1 a 8
  display.setTextColor(WHITE);
  display.setCursor(35, 10);  //Establecer las coordenadas para mostrar la posición del texto
  display.println("CARGANDO...");
  display.display();
}

void calibrando_1() {
  display.clearDisplay();
  display.setTextSize(1);  //Establece el tamaño de fuente, admite tamaños de 1 a 8
  display.setTextColor(WHITE);
  display.setCursor(30, 10);  //Establecer las coordenadas para mostrar la posición del texto
  display.println("CALIBRANDO.");
  display.display();
}
void calibrando_2() {
  display.clearDisplay();
  display.setTextSize(1);  //Establece el tamaño de fuente, admite tamaños de 1 a 8
  display.setTextColor(WHITE);
  display.setCursor(30, 10);  //Establecer las coordenadas para mostrar la posición del texto
  display.println("CALIBRANDO..");
  display.display();
}
void calibrando_3() {
  display.clearDisplay();
  display.setTextSize(1);  //Establece el tamaño de fuente, admite tamaños de 1 a 8
  display.setTextColor(WHITE);
  display.setCursor(30, 10);  //Establecer las coordenadas para mostrar la posición del texto
  display.println("CALIBRANDO...");
  display.display();
}
void colocar() {
  display.clearDisplay();
  display.setTextSize(1);  //Establece el tamaño de fuente, admite tamaños de 1 a 8
  display.setTextColor(WHITE);
  display.setCursor(10, 10);  //Establecer las coordenadas para mostrar la posición del texto
  display.println("COLOQUE EL PRODUCTO");
  display.display();
}