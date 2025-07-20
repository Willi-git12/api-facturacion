# 📄 facturacion-prod

API RESTful desarrollada con **Java 17** y **Spring Boot 3.5.3**, que permite gestionar productos y facturas.

## ⚙️ Funcionalidades
- CRUD de Productos
- CRUD de Facturas
- CRUD de Detalle de facturas

## 📦 Instalación

## ⚙️ Requisitos para ejecutar el proyecto

Antes de comenzar, asegúrate de tener instalado lo siguiente:

- ✅ [Java JDK 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- ✅ [Maven 3.8+](https://maven.apache.org/download.cgi)
- ✅ [MySQL 8+](https://dev.mysql.com/downloads/installer/)
- ✅ [Git](https://git-scm.com/)
- ✅ [Postman](https://www.postman.com/downloads/) *(opcional)*

---

## 🚀 Instalación y ejecución del proyecto

### 1. Clona el repositorio

```bash
git clone https://github.com/Willi-git12/api-facturacion.git
cd facturacion-prod
```

### 2. Configura la base de datos MySQL

Abre tu cliente MySQL y ejecuta:

```sql
CREATE DATABASE `bdd-facturacion-prod`;
```

Luego, asegúrate de que las credenciales en el archivo `src/main/resources/application.properties` coincidan con tu entorno local:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bdd-facturacion-prod
spring.datasource.username=root
spring.datasource.password=root
```

> ⚠️ Reemplaza la contraseña si no es la misma que en tu instalación local.

### 3. Compila el proyecto

```bash
mvn clean install
```

### 4. Ejecuta la aplicación

```bash
mvn spring-boot:run
```

O ejecuta la clase `FacturacionProdApplication.java` desde tu IDE, te recomiendo IntelliJ.

---

## 📡 Endpoints y pruebas

- Accede a la aplicación en:  
  👉 `http://localhost:8080/`
- Pruebala con Postman  

---

## 🧰 Tecnologías usadas

- Java 17  
- Spring Boot 3.5.3  
- Spring Data JPA  
- Spring Security  
- MySQL  
- Maven  
- Lombok  
- ModelMapper  

---

## 📂 Estructura general del proyecto

```
src/
 ├─ main/
 │   ├─ java/com/WilliApp/facturacion/
 │   │   ├─ controller/
 │   │   ├─ service/
 │   │   ├─ model/
 │   │   ├─ repository/
 │   │   └─ FacturacionProdApplication.java
 │   └─ resources/
 │       └─ application.properties
 └─ test/
```

---

## 📬 Contacto

Desarrollado por **Willioxer**  
🔗 GitHub: [Willioxer](https://github.com/Willi-git12)
🔗 LinkedIn: www.linkedin.com/in/willi-pazes
