# 🚀 El Rapidito - Sistema de Gestión Comercial e Inventario

**El Rapidito** es un sistema de escritorio desarrollado en Java para la gestión integral de cajas, inventario y facturación. Implementa una arquitectura por capas (N-Tier) y persistencia ligera con SQLite.
🎬 Demostración Visual
⚙️ Funcionamiento del Sistema
Gestión de Cajas e Inventarios: Módulo completo para la edición, consulta, guardado y eliminación de cajas y productos con actualización dinámica en la interfaz gráfica.

Persistencia con Auto-inicialización: Configurado con motor SQLite embebido. El sistema verifica automáticamente la existencia del archivo de base de datos .db al iniciar la aplicación; si no existe, lo crea en tiempo de ejecución junto con el esquema relacional necesario.

Diseño e Interfaz Limpia: Menú de navegación lateral intuitivo con estilo oscuro, controles de acceso y validación de campos para la edición de registros.

🏗️️ Arquitectura por Capas (N-Tier)
El proyecto está diseñado bajo una estricta separación de responsabilidades para garantizar la escalabilidad y mantenibilidad del código:

Plaintext
El_Rapidito/
└── src/
    ├── Datos/          # Conexión SQLite (Conexion.java), Entidades (ObjCaja, ObjUsuario) y DAO (ObjOpCajas)
    ├── Logica/         # Reglas de negocio y controladores de operaciones
    ├── Presentacion/   # Interfaz gráfica de usuario (Swing / AWT)
    └── Imagenes/       # Recursos gráficos del sistema y animación de prueba (demo.gif)
🛠️ Tecnologías Utilizadas
Lenguaje: Java (JDK)

Base de Datos: SQLite (JDBC Driver)

Arquitectura: N-Tier / Pattern DAO (Data Access Object)

Entorno de Desarrollo: Apache NetBeans / Linux (Crostini)

Control de Versiones: Git & GitHub
