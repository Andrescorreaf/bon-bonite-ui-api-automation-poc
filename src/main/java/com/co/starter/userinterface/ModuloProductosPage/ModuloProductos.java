package com.co.starter.userinterface.ModuloProductosPage;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.core.annotations.findby.By;

public class ModuloProductos {

    public static final Target LINK_PRODUCTOS = Target.the("Link Módulo Productos").located(By.id("menu_products"));
    public static final Target CATEGORIA_ZAPATOS = Target.the("Categoría Zapatos").located(By.xpath("//a[contains(.,'Zapatos') or contains(@data-category,'zapatos')]") );
    public static final Target CATEGORIA_ROPA = Target.the("Categoría Ropa").located(By.xpath("//a[contains(.,'Ropa') or contains(@data-category,'ropa')]") );
    public static final Target CATEGORIA_ACCESORIOS = Target.the("Categoría Accesorios").located(By.xpath("//a[contains(.,'Accesorios') or contains(@data-category,'accesorios')]") );
    public static final Target LISTADO_ZAPATOS = Target.the("Listado Zapatos").located(By.xpath("//h1[contains(.,'Zapatos')] | //h2[contains(.,'Zapatos')]") );
    public static final Target LISTADO_ACCESORIOS = Target.the("Listado Accesorios").located(By.xpath("//h1[contains(.,'Accesorios')] | //h2[contains(.,'Accesorios')]") );
}
