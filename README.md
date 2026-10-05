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
- [🗺️ Roadmap](#️-roadmap)
- [👤 Autor](#-autor)
- [🤝 Conectemos](#-conectemos)

---

## 🎬 Demostración visual

<div align="center">
<table>
  <tr>
    <td align="center">
      <img width="400" alt="Demo 1" src="https://github.com/user-attachments/assets/aafd0539-e79c-4a6a-8c5c-eaff0afb22aa" />
      <br><sub><b>Gestión de cajas</b></sub>
    </td>
    <td align="center">
      <img width="400" alt="Demo 2" src="[URL_DEL_GIF_2](https://github.com/user-attachments/assets/aafd0539-e79c-4a6a-8c5c-eaff0afb22aa)" />
      <br><sub><b>Inventario</b></sub>
    </td>
  </tr>
  <tr>
    <td align="center">
      <img width="400" alt="Demo 3" src="[URL_DEL_GIF_3](https://github.com/user-attachments/assets/aafd0539-e79c-4a6a-8c5c-eaff0afb22aa)" />
      <br><sub><b>Facturación</b></sub>
    </td>
    <td align="center">
      <img width="400" alt="Demo 4" src="[URL_DEL_GIF_4](https://github.com/user-attachments/assets/aafd0539-e79c-4a6a-8c5c-eaff0afb22aa)" />
      <br><sub><b>Usuarios</b></sub>
    </td>
  </tr>
</table>
</div>
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

**Erick Lopez**
Desarrollador Java · Apasionado por los sistemas de gestión y las bases de datos.

---

## 🤝 Conectemos

¿Tienes ideas, comentarios o quieres colaborar? **¡Escríbeme!**

<div align="center">

[![Email](https://img.shields.io/badge/Email-Escr%C3%ADbeme-EA4335?style=for-the-badge&logo=gmail&logoColor=white)](mailto:ericklopezborge21@gmail.com)
&nbsp;&nbsp;
[![WhatsApp](https://img.shields.io/badge/WhatsApp-Chatear-25D366?style=for-the-badge&logo=whatsapp&logoColor=white)](https://wa.me/50664407615)

<sub>📧 ericklopezborge21@gmail.com &nbsp;·&nbsp; 📱 +506 6440 7615</sub>

</div>

---

<div align="center">

⭐ Si el proyecto te resultó útil, ¡regálale una estrella!

</div>
