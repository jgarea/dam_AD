https://mp0486-add.vercel.app/docs/unidades/02/actividades/enunciado/pasos-previos

- [Aplicación para la gestión de usuarios con ficheros JSON](#aplicación-para-la-gestión-de-usuarios-con-ficheros-json)
  - [Introducción](#introducción)
  - [Pasos previos](#pasos-previos)


# Aplicación para la gestión de usuarios con ficheros JSON
## Introducción
En este proyecto vamos a desarrollar una aplicación que permita registrar usuarios y acceder a su información. Toda la información relacionada con los usuarios se almacenará en un fichero JSON.

La aplicación permitirá realizar lo siguiente:

* Crear un nuevo usuario.
* Iniciar sesión a través de un formulario de login.
* Ver la información de mi usuario.
* Cambiar la contraseña de mi usuario.
* Borrar mi usuario.
  
En el proyecto se os proporciona un paquete gui que contiene las interfaces de la aplicación y un paquete model que contiene la lógica de la aplicación. Debéis realizar las modificaciones correspondientes sobre las clases de estos paquetes.

## Pasos previos
> [!NOTE] MATERIAL A DESCARGAR
> 
> Para descargar el proyecto podéis clicar en el siguiente enlace.

Primero debéis descargar el proyecto desde el enlace anterior e importarlo.

> [!IMPORTANT] 
> NOTA IMPORTANTE
> Una vez descargado el fichero del proyecto, es necesario renombrarlo antes de poder importarlo o descomprimirlo
> 
> Por ejemplo, si el fichero descargado se llama: proyecto-unidad1.tar-ea989dab2692d9ae69a8330c92b139c2.gz habrá que renombrarlo a: proyecto-unidad1.tar para poder descomprimirlo o importarlo.

Después, para trabajar con ficheros JSON desde Java vamos a usar el paquete org.json. Para poder usarlo, debemos descargarnos el archivo .jar correspondiente desde el repositorio de Maven: Enlace Maven o bien desde el siguiente enlace

Una vez descargado, debemos añadirlo a nuestro Build Path. Para eso, haremos lo siguiente desde nuestro proyecto de Eclipse:

Click derecho > Build Path > Configure Build Path > Add External JARs 

Además, en el fichero module-info.java de nuestro proyecto tendremos que importar los paquetes java.desktop (para usar Swing) y org.json.

Con esto ya podemos empezar a trabajar.

> [!NOTE]
> Notas especial

> [!TIP]
> Consejo

> [!IMPORTANT]
> Consejo

> [!WARNING]
> Consejo

> [!CAUTION]
> Consejo