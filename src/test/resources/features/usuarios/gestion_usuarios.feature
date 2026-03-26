# language: es

@api @regresion 
Característica: Gestión de usuarios en el e-commerce
  Como usuario del sistema
  Quiero registrarme, autenticarme y gestionar mi información
  Para acceder y administrar mi cuenta correctamente


  @api @crear_usuario
  Escenario: Crear usuario exitosamente mediante API
    Dado que el actor prepara una solicitud de creación de usuario con datos válidos
    Cuando envía la solicitud al servicio de registro de usuarios
    Entonces el sistema responde con estado exitoso
    Y el usuario es creado correctamente en el sistema

  @api  @login
  Escenario: Autenticación de usuario mediante API
    Dado que el actor tiene un usuario previamente registrado
    Cuando envía las credenciales válidas al servicio de autenticación
    Entonces el sistema responde con estado exitoso
    Y retorna un token de acceso válido

  @api @actualizar_usuario
  Escenario: Actualizar información de usuario mediante API
    Dado que el actor cuenta con un usuario autenticado
    Cuando envía una solicitud para actualizar la información del usuario
    Entonces el sistema responde con estado exitoso
    Y los datos del usuario son actualizados correctamente

  @api @validacion_registro
  Escenario: Validar error al crear usuario con datos incompletos mediante API
    Dado que el actor prepara una solicitud de creación de usuario con datos incompletos
    Cuando envía la solicitud al servicio de registro
    Entonces el sistema responde con error de validación
    Y no permite la creación del usuario


  @ui @registro
  Escenario: Registro exitoso de usuario desde la interfaz web
    Dado que el actor navega al sitio web de e-commerce
    Y accede al formulario de registro
    Cuando ingresa información válida en todos los campos obligatorios
    Y envía el formulario de registro
    Entonces el sistema muestra un mensaje de confirmación
    Y el usuario queda registrado exitosamente