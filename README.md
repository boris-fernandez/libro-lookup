# 📚 **Libro Lookup**

Este proyecto es una **aplicación de consola** diseñada para facilitar la **búsqueda y exploración de libros** utilizando la **API de Gutendex**. 
Con un **backend en Spring Boot** y **PostgreSQL** como base de datos, ofrece un entorno robusto y eficiente para interactuar mediante **comandos en la terminal**. 💻🔍

## 🔑 **Funcionalidades principales**
- **Búsqueda avanzada de libros**: Realiza consultas desde la consola mediante **palabras clave**, **autores**, **géneros**, **temas** y genera **estadísticas** basadas en los resultados obtenidos. 📖✨
- **Integración con Gutendex**: Accede a un **amplio catálogo de libros** actualizados a través de esta API pública. 🌐
- **Almacenamiento local**: Guarda y administra **información relevante** en una base de datos **PostgreSQL** para consultas recurrentes.
- **Interfaz de consola intuitiva**: Los comandos son fáciles de usar, ideales para usuarios y desarrolladores. ⚡

## 🛠️ **Tecnologías Utilizadas**
- **Backend:**
  - **Java**: Lenguaje principal para el desarrollo de la aplicación. ☕
  - **Spring Boot**: Framework utilizado para estructurar el backend y gestionar la lógica de negocio. 🔥
  - **PostgreSQL**: Base de datos relacional utilizada para almacenar información sobre los libros y búsquedas realizadas.
- **API de terceros**
  - **Gutendex API**: Usada para buscar y obtener información sobre libros de dominio público de forma dinámica. 🌍

## ⚙️ **Configuración del Proyecto**
1. **Crear archivo `.env`:**
   - Copia el archivo de ejemplo `.env.example` que se encuentra en la raíz del proyecto y renómbralo a `.env`. 📝
   - Edita el archivo `.env` con las credenciales de tu base de datos. 🔑
   - **Ejemplo de configuración:**
     ```bash
     DB_URL = jdbc:postgresql://localhost/nombre_BD
     DB_USER = tu_usuario
     DB_PASSWORD = tu_contraseña
     ```

## 🚀 **Próximas Mejoras**
- Se está **planificando una interfaz de usuario (UI)** en el futuro para facilitar aún más la interacción con la aplicación, ¡haciendo que la experiencia sea aún más intuitiva! 🌟
- **Integración de nuevas funcionalidades** como filtros avanzados y recomendaciones personalizadas. 💡

### 💬 **¡Gracias por visitar el proyecto!**
Si tienes alguna pregunta o sugerencia, no dudes en **abrir un issue** o **contribuir** al repositorio. Tu feedback es muy valioso para seguir mejorando. ¡Esperamos que disfrutes utilizando **Libro Lookup**! 😄
¡Feliz codificación! 🚀👨‍💻👩‍💻
