# language: es

Característica: Responder questionario del formulario
  Como usuario
  Quiero ir a la pagina del questionario
  Para responder de manera exitos

  Escenario: Responder el questionario 10 veces
    Dado que el usuario esta en la pagina del questionario
    Cuando el usuario completa el formulario del questionario exitoso
    Entonces debe ser redirigido a una pagina con un hash de exito