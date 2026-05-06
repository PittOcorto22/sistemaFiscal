Sistema de Gestión de Accesos y Auditoría Fiscal

Este proyecto es una implementación en Java para organizar de forma clara los usuarios, los roles institucionales y los recursos de información disponibles en la base de datos de la institución. 

El sistema está dividido en tres módulos principales para resolver las problemáticas planteadas:

Modelo de Datos: Estructura que organiza a los usuarios del sistema, como auditores, analistas fiscales, supervisores y administradores técnicos. Se desarrolló una implementación en Java que representa el modelo de usuarios, roles y permisos definido durante el análisis.

Flujo de Validación: Simula las verificaciones que ocurren cada vez que un funcionario inicia sesión en el sistema e intenta acceder a un registro fiscal. El sistema primero comprueba la identidad del usuario y confirma que su cuenta está activa, luego identifica el rol institucional y determina si tiene autorización, y finalmente verifica si el usuario pertenece a la unidad administrativa responsable.

Procesamiento de Logs: Herramienta diseñada para procesar automáticamente los registros de auditoría y generar reportes. El programa permite identificar qué usuarios realizan un número inusualmente alto de consultas, qué recursos son los más solicitados y qué tipos de operaciones generan más errores.

Como usarlo:

1. Descargar el archivo zip
2. Abrir el proyecto en el cualquier IDE
3. Ejecutar la clase principal `SistemaFiscalApp.java` para inicializar la simulación en consola.
