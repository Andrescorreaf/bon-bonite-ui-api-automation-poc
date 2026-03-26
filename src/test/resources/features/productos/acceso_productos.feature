# language: es

@ui @producto @acceso
Característica: Acceso a módulo de productos
  Como usuario
  Quiero acceder al módulo de Zapatos
  Para ver y filtrar los productos disponibles

  @ui @zapatos
  Escenario: Acceder a la sección de Zapatos
    Dado que el actor está en la página principal
    Cuando navega al módulo de productos
    Y selecciona la categoría "Zapatos"
    Entonces visualiza la lista de zapatos

  @ui @categoria
  Escenario: Navegación entre categorías de productos
    Dado que el actor está en el módulo de productos
    Cuando selecciona la categoría "Ropa"
    Y selecciona la categoría "Accesorios"
    Entonces visualiza la sección de accesorios