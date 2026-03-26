# language: es

@api @regresion 
Característica: Gestión de usuarios en el 
  Como usuario del sistema
  Quiero registrarme, autenticarme y gestionar mi información
  Para acceder y administrar mi cuenta correctamente


  @api @crear_usuario
  Escenario: Crear usuario exitosamente mediante API
    Dado que el actor prepara una solicitud de creación de usuario con datos válidos
    Cuando envía la solicitud al servicio de registro de usuarios
    Entonces el sistema responde con estado exitoso
    Y el usuario es creado correctamente en el sistema

  @ui @login
  Escenario: Autenticación de usuario mediante UI
    Dado que el actor navega al sitio web de bon-bonite.com
    Y registra un usuario para login
    Y accede al formulario de login
    Cuando ingresa las credenciales válidas para login
    Y envía el formulario de login
    Entonces el sistema permite el acceso
    Y el usuario accede exitosamente

  @api @actualizar_usuario
  Escenario: Actualizar información de usuario mediante API
    Dado que el actor cuenta con un usuario autenticado
    Cuando envía una solicitud para actualizar la información del usuario
    Entonces el sistema responde con estado exitoso
    Y los datos del usuario son actualizados correctamente

  @ui @validacion_registro
  Escenario: Validar error al crear usuario con datos incompletos mediante UI
    Dado que el actor prepara una solicitud de creación de usuario con datos incompletos
    Cuando envía la solicitud al servicio de registro
    Entonces el sistema responde con error de validación
    Y no permite la creación del usuario


  @ui @registro
  Escenario: Ir a registro desde mi-cuenta y completar formulario
    Dado que el actor navega al sitio web de bon-bonite.com
    Y accede al formulario de registro
    Cuando ingresa credenciales válidas
    Y envía el formulario de login
    Entonces el sistema permite el acceso
    Y el usuario accede exitosamente