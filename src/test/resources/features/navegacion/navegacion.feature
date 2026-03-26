# language: es

@ui @regresion
Característica: Navegación en el e-commerce
  Como usuario del sitio web
  Quiero navegar entre las diferentes secciones
  Para explorar productos y acceder a funcionalidades del sistema

  @ui @manual @categoria
  Escenario: Navegación a la categoría de productos
    Dado que el usuario se encuentra en la página principal
    Cuando selecciona la categoría "Zapatos"
    Entonces el sistema muestra los productos disponibles

  @ui @manual @pqrs
  Escenario: Acceso al módulo de PQRS
    Dado que el usuario se encuentra en el sitio web
    Cuando accede a la sección de PQRS
    Entonces el sistema muestra el formulario de contacto