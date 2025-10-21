# Mini Home Banking (Aplicación de Escritorio)

## Descripción
Este es un **sistema de mini home banking de escritorio** desarrollado en **Java**, utilizando **Swing** para la interfaz de usuario y **JDBC** para la interacción con la base de datos.  
La aplicación permite a los usuarios gestionar cuentas bancarias y tarjetas de crédito, realizar transferencias, ver historiales de transacciones y generar resúmenes de cuentas.  
Los administradores pueden crear usuarios y asignarles productos bancarios.

## Características principales
- **Gestión de usuarios:** Crear y autenticar usuarios (clientes y administradores).  
- **Gestión de cuentas:** Los usuarios pueden tener múltiples cuentas (caja de ahorro, cuenta corriente, caja de ahorro en dólares, etc.).  
- **Transacciones:** Registro de débitos, créditos y transferencias en tiempo real.  
- **Tarjetas de crédito:** Los usuarios pueden tener múltiples tarjetas, con seguimiento de saldo y resúmenes mensuales.  
- **Reportes y auditoría:** Auditoría opcional de acciones de usuarios y resúmenes de transacciones.

## Tecnologías
- Java (Swing para la GUI)  
- JDBC para la interacción con la base de datos  
- PlantUML para la documentación de diseño orientado a objetos

## Instalación
1. Clonar el repositorio:  
   ```bash
   git clone https://github.com/tu-usuario/MiniHomeBanking.git
   ```
2. Abrir el proyecto en tu IDE de Java.
3. Configurar la base de datos H2 e iniciarla:
   ```bash
   java -har h2-2.4.240.jar
   ````
4. Compilar y ejecutar la aplicación.

## Diagrama de Clases UML (PLantUML Code: ![UML](MiniHomeBanking.puml))
<img width="1931" height="913" alt="image" src="https://github.com/user-attachments/assets/fac1333e-6c8d-45da-9068-103b596bf962" />

## Idea para UI
<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/ee178fd7-7f99-4479-969f-f208dabf4e40" />
