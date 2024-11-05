- El programa incialmente intenta crear la base de datos junto con todas sus tablas si esta no está creada. Es por eso que antes de poder usar las funciones que ofrecemos habría que crear algunas monedas con las que realiozar operaciones.

- A medida que avanzamos con el proyecto, fuimos creando los metodos DAO que nos eran necesarios, es por eso que no todas nuestras clases DAO cumplen la caracteristica de cumplir con las operaciones CRUD, solo tienen aquellos metodos necesarios para la resolucion de los problemas.

- En los metodos de los DAO decidimos que cada metodo pueda crear una coneccion, trabajar con ella, cerrarla y devolver el resultado. Lo hicimos de esta manera para asegurarnos de que no quedasen conecciones abiertas y abstraer a el programa principal de tener que gestionar estas conecciones.

- Nosotros consideramos la posibilidad de trabajar con mas de un Usuario en nuestra base de datos, es por eso que en la tabla de Activos existe la columna "idUsuario" para poder vincular a cada Activo con su Usuario propietario. En este entregable usamos un id por defecto que es 0.

- Teniendo en cuenta lo aclarado anteriormente, es que decidimos no vincularle a los reportes el id del usuario que llevó a cabo la operación.

