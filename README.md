# Api_SpringBooot_Rest
Saludos

Este proyecto crea una Api Rest utilizando Sprin Boot, JPA , JDBC, MySql Driver, Hibernate, Spring Web, BD MySql, Lombook. 
Aplicanido Patrones de diseño , capas de persistencia, Inyeccion de dependecias - Responsabilidad unica "SOLID" y buenas practicas. 

El reto es hacer una API REST y un CRUD para nuestra base de datos en este caso tendremos equipos de futbol
y cada equipo tendra almenos un jugador, tambien comsumiedo la Api podremos crear un nuevo equipo , actualizar un equipo y eliminar un equipo.
Tambien se podra crear jugadores para cualquier equipo, actualizar jugadores y eliminar jugadores.

Primer paso seria vincular nuestro proyecto a nuestra base de datos; En este caso nuestra BD tendra el nombre de api_rest_equipo_db.

![image](https://github.com/leopn11/Api_SpringBooot_Rest/assets/109111125/6e0f5142-6915-4d3c-9420-23bd28143e6a)

Seguido creamos nuestras entidades las cuales se guardaran en la base de datos como "equipo" y "jugador" con sus atributos cada una y con su relacion de uno a muchos
que en este caso sera la entidad equipo  y de muchos a uno que sera la entidad jugador la cual tendra un @Join que indicara la foreign key id_equipo que vincula 
nuestras dos entidades. Ya que saldra el id del equipo al que quedara vinculado el jugador.

![image](https://github.com/leopn11/Api_SpringBooot_Rest/assets/109111125/4a897bd0-ace7-42bf-9462-465bba70768e)

Seguido crearemos nuestro repositorio en este caso seran interfaces que implementan la interfas CrubRepository que nos da acceso a sus metodos y en ella debemos 
vincular la entidad y el tipo de dato que tiene nuestro identificador unico.

aca hay una anotacio @Query que utilizamos para comparar un precio. Se compara precio 1 con el precio 2.

![image](https://github.com/leopn11/Api_SpringBooot_Rest/assets/109111125/d05fc3a2-9338-4a43-a66a-a0853187df99)

Luego creamos nuestro paquete de persistencia el cual separa debidamente la parte de base de datos con la capa de servicio que implementa nuestro crud de nuestra aplicacion,
en este implementamos un DAO (Data Accest Object) patron de diseño que nos ayuda a crear nuestros metodos de una manera mas sencilla. 

![image](https://github.com/leopn11/Api_SpringBooot_Rest/assets/109111125/e4c4245e-d029-421b-b6dc-f40c9a172f7b)

Implementamos nuestro DAO  y inyectamos nuestros repositirios para que se pueda acceder a todos los metodos.

![image](https://github.com/leopn11/Api_SpringBooot_Rest/assets/109111125/f5df8af2-ab0b-410b-ad0f-b4528122d9d4)

Ya teniendo nuestra capa de persistencia creada pasamos a nuestro servicio donde se implementaran los metodos en nuestra aplicación serian los mismos 
que hay en nuestro DAO inyectandolo tambien y accediendo a los metodos con equipoDAO y jugadorDAO.

![image](https://github.com/leopn11/Api_SpringBooot_Rest/assets/109111125/5846d742-6a61-4ed2-9da6-375b066f8aeb)

![image](https://github.com/leopn11/Api_SpringBooot_Rest/assets/109111125/ff516cb5-1e8c-4c29-a51b-38a1a99a195e)

Por ultimo creamos nuestro controlador donde construiremos nuestras funciones para nuestro CRUD. 

Iniciamos buscando equipo y jugador por su id. 

En cada uno nos devuelve un optional ya que puede tener valores que no estan o son nulos o si pueden estar.
Esta función es de tipo GET ya que nos permite mostrar el equipo y jugador por su id si es que esta presente si no esta presente nos devuelve 
un badRequest es un codigo de respuesta a un error HTTP 400 indicando que la solicitud es incorrecta.

![image](https://github.com/leopn11/Api_SpringBooot_Rest/assets/109111125/3029b792-3fe5-40c8-a729-ab6d0be2a0ce)
![image](https://github.com/leopn11/Api_SpringBooot_Rest/assets/109111125/a9f8324c-1908-4b5e-80d6-b1cb27c651dd)

En estas imagenes vemos como consumimos nuestra api para buscar por el id desde postman.

![image](https://github.com/leopn11/Api_SpringBooot_Rest/assets/109111125/fbeb1154-6944-4735-9afd-f8db5601614b)
![image](https://github.com/leopn11/Api_SpringBooot_Rest/assets/109111125/e67778b1-8850-48d9-ac6d-26b244e60c4d)

Seguido de otra función de tipo GET que es una lista para buscar a todos los equipos utilizamos un api stream para trabajar con colecciones de datos o listas 
y el metodo map para pasar de entidad a DTO y terminamos con el metodo toList() para convertir el stream a una lista.

![image](https://github.com/leopn11/Api_SpringBooot_Rest/assets/109111125/7581efd5-20f5-4502-bb3e-e9527002e89c)
![image](https://github.com/leopn11/Api_SpringBooot_Rest/assets/109111125/434fda2a-477e-4839-8d79-9ddb41f28f6e)

Utilizamos postman para asegurarnos de que podemos buscar todos.

![image](https://github.com/leopn11/Api_SpringBooot_Rest/assets/109111125/06411dad-b0e0-41d7-a475-c1ce7c6dfee6)

Creamos otra función de tipo POST  para guardar un equipo o un jugador aqui nos aseguramos si el nombre ya sea del equipo o del jugador esta en blanco o el precio
del jugador es nulo o el equipo del jugador es nulo en este caso retornamos una respuesta 400.

Si esto no se cumple entonces se convierte a DTO y creamos un jugador o equipo con el metodo save().
Y retornamos con el metodo created() para asegurarnos que se a creado un nuevo recurso con exito.

![image](https://github.com/leopn11/Api_SpringBooot_Rest/assets/109111125/fadba92a-987a-4d34-a8a3-a34e72710bb9)
![image](https://github.com/leopn11/Api_SpringBooot_Rest/assets/109111125/dadd2b19-4638-463f-996b-f99ddab4371b)

En esta imagen podemos ver como se guarda un equipo en base de datos desde postman.

![image](https://github.com/leopn11/Api_SpringBooot_Rest/assets/109111125/56313a5f-706f-4ff6-820c-85afd7bf8669)

Y aqui podemos ver como se guarda un jugador en la base de datos desde postman.

![image](https://github.com/leopn11/Api_SpringBooot_Rest/assets/109111125/29bf4caa-0b15-4a8d-9427-3e02bf95f2a8)

Seguido creamos una función de tipo PUT para actualizar un equipo o un jugador hay que revisar si un equipo o jugador esta presente por su id 
luego pasamos un nuevo equipo o jugador lo creamos con el metodo save().

Si esto no se cumple retornomos un codigo de error 400.

![image](https://github.com/leopn11/Api_SpringBooot_Rest/assets/109111125/6c49f67a-19d8-45f8-a57b-f2498b3fb843)
![image](https://github.com/leopn11/Api_SpringBooot_Rest/assets/109111125/67df0800-2117-48cc-8571-c85b0ea07029)

Aqui podemos ver como actualizamos un jugador por su id desde postman y miramos si se actualizo en base de datos.

![image](https://github.com/leopn11/Api_SpringBooot_Rest/assets/109111125/ce3a5ec7-72f9-4b57-b29e-e9f0acb6277a)

Y aquí podemos ver como se actualiza un equipo desde postman y se actualiza en base de datos.

![image](https://github.com/leopn11/Api_SpringBooot_Rest/assets/109111125/1f665beb-b0c5-4dd8-8d25-b6217826170d)

por ultimo para completar nuestro CRUD creamos una función de tipo DELETE y en ella miramos si el id del equipo o jugador es diferente a nulo 
entonces lo eliminamos y si es nulo entonces retornamos badRequest.

![image](https://github.com/leopn11/Api_SpringBooot_Rest/assets/109111125/c0529e0f-5766-403b-8026-dbe6ef638187)
![image](https://github.com/leopn11/Api_SpringBooot_Rest/assets/109111125/97bbe4ce-730d-43f2-9297-55786a923eda)

Podemos ver como elimnamos el jugador de la base de datos desde postman.

![image](https://github.com/leopn11/Api_SpringBooot_Rest/assets/109111125/be47e45d-2f1e-40b1-86fe-f326e0df9874)

Y aqui como se elimina un equipo de la base de datos desde postman.

![image](https://github.com/leopn11/Api_SpringBooot_Rest/assets/109111125/6f1bfd3c-e93c-4a17-b19b-0c32b6b0fff5)

Importante.

Implementamos un DTO (Data Transfer Object). Es un patron de diseño que nos permite la transferncia de datos, en este caso
convertimos las entidades a DTO por que no se puede y es mala practica retornar entidades en nuestros controladores.

![image](https://github.com/leopn11/Api_SpringBooot_Rest/assets/109111125/5a67ae65-5d37-46f2-b4dc-164cca7d7dc1)

Tambien en este proyecto empleamos el patron Builder el cual nos permite crear objetos de una forma sencilla como lo representa la imagen.

![image](https://github.com/leopn11/Api_SpringBooot_Rest/assets/109111125/14acbc47-d04a-46c6-a844-043486ac9891)

Y por ultimo con este archivo import.sql poblamos nuestra base de datos.

![image](https://github.com/leopn11/Api_SpringBooot_Rest/assets/109111125/f951fcc5-2fbb-4288-9b6b-780115c730ed)








