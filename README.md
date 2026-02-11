# Evaluacion 1 - Plataformas de Programacion Empresarial

## Requisitos

- Java 25 o superior.

## Ejecutar el paquete

Este proyecto publica un archivo JAR en la seccion **Releases** de GitHub. Para ejecutarlo hay que:

1) Entrar a Releases y descargar el archivo `.jar` del release.
2) En la terminal, ejecutar el JAR con Java 25 o superior:

```bash
java -version
java -jar eval1PPE-1.0.1.jar
```

Si el archivo tiene otro nombre o version, reemplazar el nombre en el comando anterior.

## Por que elegí estrategia Trunk?

Elegí la estrategia Trunk porque es la que más se usa en proyectos de software modernos. Quería aprender a usarla y entender su flujo de trabajo.

## Explicación de las herramientas usadas en el pipeline

#### Triggers
- **Pull Request**: Valida que el código compile y funcione antes de mergear.
- **Push a main**: Después de mergear, automáticamente crea una versión publicada.

#### Pasos del pipeline

1. **Checkout**: Descarga el código del repositorio.
2. **Setup Java**: Configura Java 25.
3. **Build**: Ejecuta `./gradlew build` para compilar el proyecto y descargar dependencias.
4. **Artifact**: Guarda el archivo `.jar` generado.
5. **Release**: Crea automáticamente un tag y release en GitHub con el número de versión desde `build.gradle`.
