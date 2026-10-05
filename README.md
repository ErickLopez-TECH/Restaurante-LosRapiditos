<div align="center">

# 🚀 El Rapidito

### Sistema de Gestión Comercial e Inventario

Aplicación de escritorio para la gestión integral de **cajas, inventario y facturación**,
construida con arquitectura por capas y persistencia ligera.

![Java](https://img.shields.io/badge/Java-JDK-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![SQLite](https://img.shields.io/badge/SQLite-JDBC-003B57?style=for-the-badge&logo=sqlite&logoColor=white)
![NetBeans](https://img.shields.io/badge/Apache_NetBeans-1B6AC6?style=for-the-badge&logo=apachenetbeanside&logoColor=white)
![Linux](https://img.shields.io/badge/Linux-Crostini-FCC624?style=for-the-badge&logo=linux&logoColor=black)
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)

</div>

---

## 📑 Tabla de contenido

- [🎬 Demostración visual](#-demostración-visual)
- [✨ Características](#-características)
- [🏗️ Arquitectura](#️-arquitectura-por-capas-n-tier)
- [📂 Estructura del proyecto](#-estructura-del-proyecto)
- [🛠️ Tecnologías](#️-tecnologías-utilizadas)
- [⚙️ Instalación y ejecución](#️-instalación-y-ejecución)
- [🗺️ Roadmap](#️-roadmap)
- [👤 Autor](#-autor)
- [🤝 Conectemos](#-conectemos)

---

## 🎬 Demostración visual

<div align="center">

<img src="El_Rapidito%28modific/src/Imagenes/demo.gif" alt="Demostración de El Rapidito" width="800">

*Navegación, edición y consulta de cajas e inventario en tiempo real.*

</div>

> 💡 **Nota:** si el GIF no se muestra, verifica que el archivo exista en `src/Imagenes/demo.gif`
> y que la ruta del enlace coincida exactamente (GitHub distingue mayúsculas y minúsculas).

---

## ✨ Características

| | Funcionalidad | Descripción |
|---|---|---|
| 📦 | **Gestión de cajas e inventarios** | Módulo completo para **editar, consultar, guardar y eliminar** cajas y productos, con actualización dinámica de la interfaz gráfica. |
| 💾 | **Persistencia con auto-inicialización** | Motor **SQLite embebido**. Al iniciar, el sistema verifica si existe el archivo `.db`; si no, lo crea en tiempo de ejecución junto con el esquema relacional necesario. |
| 🎨 | **Interfaz limpia** | Menú de navegación lateral con estilo oscuro, controles de acceso y validación de campos en la edición de registros. |
| 🧱 | **Código mantenible** | Separación estricta de responsabilidades para facilitar la escalabilidad. |

---

## 🏗️ Arquitectura por capas (N-Tier)

El proyecto sigue una separación estricta de responsabilidades:

```
┌─────────────────────────────────────┐
│   Presentación  (Swing / AWT)       │  ← Interfaz gráfica
├─────────────────────────────────────┤
│   Lógica        (Reglas de negocio) │  ← Controladores de operaciones
├─────────────────────────────────────┤
│   Datos         (DAO + Entidades)   │  ← Acceso a datos
├─────────────────────────────────────┤
│   SQLite        (JDBC)              │  ← Persistencia
└─────────────────────────────────────┘
```

Se aplica el patrón **DAO (Data Access Object)** para aislar el acceso a la base de datos del resto de la aplicación.

---

## 📂 Estructura del proyecto

```text
El_Rapidito/
└── src/
    ├── Datos/          # Conexión SQLite (Conexion.java), Entidades (ObjCaja, ObjUsuario) y DAO (ObjOpCajas)
    ├── Logica/         # Reglas de negocio y controladores de operaciones
    ├── Presentacion/   # Interfaz gráfica de usuario (Swing / AWT)
    └── Imagenes/       # Recursos gráficos del sistema y animación de prueba (demo.gif)
```

---

## 🛠️ Tecnologías utilizadas

| Categoría | Tecnología |
|---|---|
| **Lenguaje** | Java (JDK) |
| **Base de datos** | SQLite (JDBC Driver) |
| **Arquitectura** | N-Tier / Patrón DAO |
| **Interfaz** | Swing / AWT |
| **Entorno de desarrollo** | Apache NetBeans · Linux (Crostini) |
| **Control de versiones** | Git & GitHub |

---

## ⚙️ Instalación y ejecución

### Requisitos previos

- [JDK](https://adoptium.net/) 8 o superior
- Driver JDBC de SQLite (`sqlite-jdbc`) agregado al classpath
- Apache NetBeans (recomendado) o cualquier IDE compatible con Java

### Pasos

```bash
# 1. Clonar el repositorio
git clone https://github.com/TU_USUARIO/El_Rapidito.git

# 2. Entrar al directorio
cd El_Rapidito
```

3. Abre el proyecto en **Apache NetBeans** (`File → Open Project`).
4. Agrega el JAR de `sqlite-jdbc` a las librerías del proyecto.
5. Ejecuta la clase principal con **Run Project** (`F6`).

> 🗄️ **No necesitas crear la base de datos manualmente.** En el primer arranque el sistema genera
> el archivo `.db` y el esquema relacional automáticamente.

---

## 🗺️ Roadmap

- [x] CRUD de cajas e inventario
- [x] Auto-inicialización de la base de datos
- [x] Menú lateral con tema oscuro
- [ ] Módulo de facturación completo
- [ ] Gestión de roles y permisos de usuario
- [ ] Reportes y exportación (PDF / Excel)
- [ ] Respaldo automático de la base de datos

---

## 👤 Autor

**Tu Nombre**
Desarrollador Java · Apasionado por los sistemas de gestión y las bases de datos.

---

## 🤝 Conectemos

¿Tienes ideas, comentarios o quieres colaborar? ¡Escríbeme!

<div align="center">

[![GitHub](https://img.shields.io/badge/GitHub-TU__USUARIO-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/TU_USUARIO)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Tu_Nombre-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/TU_PERFIL)
[![Email](https://img.shields.io/badge/Email-tu__correo@gmail.com-EA4335?style=for-the-badge&logo=gmail&logoColor=white)](mailto:tu_correo@gmail.com)
[![WhatsApp](https://img.shields.io/badge/WhatsApp-Chatear-25D366?style=for-the-badge&logo=whatsapp&logoColor=white)](https://wa.me/506XXXXXXXX)

</div>

---

<div align="center">

⭐ Si el proyecto te resultó útil, ¡regálale una estrella!

</div>
