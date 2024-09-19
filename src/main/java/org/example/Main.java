package org.example;
import jdk.swing.interop.SwingInterOpUtils;
import lombok.*;

import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("modelo2PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            TipoPromocion horaFeliz = TipoPromocion.happyHour;


            UnidadMedida unidadMedida = UnidadMedida.builder().denominacion("8 Porciones").build();
            UnidadMedida unidadMedida2 = UnidadMedida.builder().denominacion("4 Porciones").build();
            UnidadMedida unidadMedida3 = UnidadMedida.builder().denominacion("1Litro").build();


            Imagen imagen1 = Imagen.builder().denominacion("Imagen Pizza grande hawaiana").build();
            Imagen imagen2 = Imagen.builder().denominacion("Imagen Pizza grande napolitana").build();
            Imagen imagen3 = Imagen.builder().denominacion("Imagen Pizza grande muzza").build();

            Imagen imagen4 = Imagen.builder().denominacion("Imagen Pizza chica hawaiana").build();
            Imagen imagen5 = Imagen.builder().denominacion("Imagen Pizza chica napolitana").build();
            Imagen imagen6 = Imagen.builder().denominacion("Imagen Pizza chica muzza").build();

            Imagen imagen7 = Imagen.builder().denominacion("Imagen Cerveza Andes").build();
            Imagen imagen8 = Imagen.builder().denominacion("Imagen Cerveza Quilmes").build();

            Imagen happyhour1 = Imagen.builder().denominacion("Imagen Happy Hour 1").build();
            Imagen happyhour2 = Imagen.builder().denominacion("Imagen Happy Hour 2").build();

            Imagen verano1 = Imagen.builder().denominacion("Imagen Verano 1").build();
            Imagen verano2 = Imagen.builder().denominacion("Imagen Verano 2").build();

            Imagen invierno1 = Imagen.builder().denominacion("Imagen Invierno 1").build();
            Imagen invierno2 = Imagen.builder().denominacion("Imagen Invierno 2").build();


            Articulo grandeHawaiana = Articulo.builder()
                    .denominacion("Pizza grande Hawaiana,").precioVenta(100.0).precioCompra(35.0).stockActual(20).stockMaximo(25).unidadMedida(unidadMedida).imagen(imagen1).build();
            Articulo chicaHawaiana = Articulo.builder()
                    .denominacion("Pizza chica Hawaiana,").precioVenta(60.0).precioCompra(20.0).stockActual(20).stockMaximo(25).unidadMedida(unidadMedida2).imagen(imagen4).build();
            Articulo grandeNapolitana = Articulo.builder()
                    .denominacion("Pizza grande Napolitana,").precioVenta(135.0).precioCompra(50.0).stockActual(14).stockMaximo(25).unidadMedida(unidadMedida).imagen(imagen2).build();
            Articulo chicaNapolitana = Articulo.builder()
                    .denominacion("Pizza chica Napolitana,").precioVenta(75.0).precioCompra(25.0).stockActual(3).stockMaximo(25).unidadMedida(unidadMedida2).imagen(imagen5).build();
            Articulo grandeMuzza = Articulo.builder()
                    .denominacion("Pizza grande Muzza,").precioVenta(135.0).precioCompra(50.0).stockActual(14).stockMaximo(25).unidadMedida(unidadMedida).imagen(imagen3).build();
            Articulo chicaMuzza = Articulo.builder()
                    .denominacion("Pizza chica Muzza,").precioVenta(50.0).precioCompra(20.0).stockActual(10).stockMaximo(25).unidadMedida(unidadMedida2).imagen(imagen6).build();
            Articulo cervezaAndes = Articulo.builder()
                    .denominacion("Cerveza Andes").precioVenta(30.0).precioCompra(20.0).stockActual(35).stockMaximo(50).unidadMedida(unidadMedida3).imagen(imagen7).build();
            Articulo cervezaQuilmes = Articulo.builder()
                    .denominacion("Cerveza Quilmes").precioVenta(20.0).precioCompra(12.0).stockActual(22).stockMaximo(35).unidadMedida(unidadMedida3).imagen(imagen8).build();


            //Happy Hour
            HashSet<Articulo> articulosHappyHour = new HashSet<>();
            articulosHappyHour.add(grandeHawaiana);
            articulosHappyHour.add(grandeMuzza);
            articulosHappyHour.add(cervezaQuilmes);
            //Imagen
            HashSet<Imagen> imagenesHappyHour = new HashSet<>();
            imagenesHappyHour.add(happyhour1);
            imagenesHappyHour.add(happyhour2);

            //Verano
            HashSet<Articulo> articulosVerano = new HashSet<>();
            articulosVerano.add(chicaHawaiana);
            articulosVerano.add(grandeNapolitana);
            articulosVerano.add(cervezaQuilmes);
            articulosVerano.add(cervezaAndes);
            //Imagen
            HashSet<Imagen> imagenesVerano = new HashSet<>();
            imagenesVerano.add(verano1);
            imagenesVerano.add(verano2);

            //Invierno
            HashSet<Articulo> articulosInvierno = new HashSet<>();
            articulosInvierno.add(grandeHawaiana);
            articulosInvierno.add(chicaMuzza);
            articulosInvierno.add(cervezaQuilmes);
            //Imagen
            HashSet<Imagen> imagenesInvierno = new HashSet<>();
            imagenesInvierno.add(invierno1);
            imagenesInvierno.add(invierno2);

            Promocion promocionHappyHour = Promocion.builder()
                    .denominacion("Promocion HappyHour: 1 Pizza grande Hawaiana,  1 Pizza grande Muzza, 1 Cerveza Quilmes")
                    .fechaDesde(LocalDate.of(2024, 9, 2))
                    .fechaHasta(LocalDate.of(2024, 10, 20)).horaDesde(LocalTime.now())
                    .horaHasta(LocalTime.now())
                    .descripcionDescuento("Descuento en los productos del happy hour")
                    .precioPromocional(3699.99)
                    .tipoPromocion(TipoPromocion.happyHour)
                    .imagenPromo(imagenesHappyHour)
                    .articulos(articulosHappyHour).build();

            entityManager.persist(promocionHappyHour);

            Promocion promocionVerano = Promocion.builder()
                    .denominacion("Promocion Verano: 1 Pizza chica Hawaiana,  1 Pizza grande Napolitana, 1 Cerveza Quilmes y 1 Cerveza Andes")
                    .fechaDesde(LocalDate.of(2024, 12, 21))
                    .fechaHasta(LocalDate.of(2024, 3, 20))
                    .horaDesde(LocalTime.now())
                    .horaHasta(LocalTime.now())
                    .descripcionDescuento("Descuento en la temporada de Verano")
                    .precioPromocional(3599.99)
                    .tipoPromocion(TipoPromocion.Verano)
                    .imagenPromo(imagenesVerano)
                    .articulos(articulosVerano).build();

            entityManager.persist(promocionVerano);

            Promocion promocionInvierno = Promocion.builder()
                    .denominacion("1 Pizza grande Hawaiana,  1 Pizza chica Muzza, 1 Cerveza Quilmes.")
                    .fechaDesde(LocalDate.of(2024, 6, 21))
                    .fechaHasta(LocalDate.of(2024, 9, 20))
                    .horaDesde(LocalTime.now())
                    .horaHasta(LocalTime.now())
                    .descripcionDescuento("Descuento en la promocion 1")
                    .precioPromocional(4999.99)
                    .tipoPromocion(TipoPromocion.Invierno)
                    .imagenPromo(imagenesInvierno)
                    .articulos(articulosInvierno).build();

            List<Articulo> articulos = new ArrayList<>();
            Collections.addAll(articulos, grandeHawaiana, chicaHawaiana, grandeNapolitana, chicaNapolitana, grandeMuzza, chicaMuzza, cervezaAndes, cervezaQuilmes);
            entityManager.persist(promocionInvierno);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }


        boolean salir = false;
        Scanner leerNum = new Scanner(System.in);
        while (!salir) {
            System.out.println("*****************************");
            System.out.println("1-Mostrar todas las promociones");
            System.out.println("2-Mostrar todos los articulos");
            System.out.println("3-Mostrar cada promociones por separado y los articulos con su precio");
            System.out.println("4-Mostrar el dia y horario de la promocion de verano");
            System.out.println("5-Mostrar cual es la promocion mas economica de las 3\n");
            System.out.println("Otro- Salir\n");
            int numero = leerNum.nextInt();
            switch (numero) {
                case 1:

                    try {
                        TypedQuery<Promocion> query = entityManager.createQuery("SELECT p FROM Promocion p", Promocion.class);
                        List<Promocion> listaPromociones = query.getResultList();
                        System.out.println("-----------------PROMOCIONES-----------------");
                        System.out.println("-----------------HAPPY HOUR-----------------");
                        System.out.println(listaPromociones.get(0).toString());

                        System.out.println("-----------------VERANO-----------------");
                        System.out.println(listaPromociones.get(1).toString());

                        System.out.println("-----------------INVIERNO-----------------");
                        System.out.println(listaPromociones.get(2).toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                    break;
                case 2:
                    System.out.println("-----------------ARTICULOS-----------------");
                    try {
                        TypedQuery<Articulo> query = entityManager.createQuery("SELECT a FROM Articulo a", Articulo.class);
                        List<Articulo> listaArticulos = query.getResultList();
                        for (Articulo articulo : listaArticulos) {
                            System.out.println(articulo);
                            System.out.println("**********************");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        TypedQuery<Promocion> query = entityManager.createQuery("SELECT p FROM Promocion p", Promocion.class);
                        List<Promocion> listaPromociones = query.getResultList();

                        System.out.println("-----------------PROMOCIONES-----------------");
                        System.out.println("-----------------HAPPY HOUR-----------------");
                        System.out.println("Precio: " + listaPromociones.get(0).getPrecioPromocional());
                        System.out.println("Descripcion: " + listaPromociones.get(0).getDescripcionDescuento());
                        System.out.println("\nArticulos:");
                        int cantidad = 1;
                        for (Articulo art : listaPromociones.get(0).getArticulos()) {
                            System.out.println("**Articulo " + cantidad + "**");
                            System.out.println(art.toString());
                            cantidad += 1;
                        }
                        cantidad = 1;
                        System.out.println("-----------------VERANO-----------------");
                        System.out.println(listaPromociones.get(1).toString());
                        for (Articulo art : listaPromociones.get(1).getArticulos()) {
                            System.out.println("**Articulo " + cantidad + "**");
                            System.out.println(art.toString());
                            cantidad += 1;
                        }

                        cantidad = 1;
                        System.out.println("-----------------INVIERNO-----------------");
                        System.out.println(listaPromociones.get(2).toString());
                        for (Articulo art : listaPromociones.get(2).getArticulos()) {
                            System.out.println("**Articulo " + cantidad + "**");
                            System.out.println(art.toString());
                            cantidad += 1;
                        }
                    } catch (Exception e) {
                        System.out.println("error al traer los datos");
                    }
                    break;
                case 4:
                    try {
                        System.out.println("-----------------FECHA Y HORA DE PROMO VERANO-----------------");
                        TypedQuery<Promocion> query = entityManager.createQuery("SELECT p FROM Promocion p", Promocion.class);
                        List<Promocion> listaPromociones = query.getResultList();
                        System.out.println("Desde :" + listaPromociones.get(1).getFechaDesde() + "a las " + listaPromociones.get(1).getHoraDesde());
                        System.out.println("Hasta :" + listaPromociones.get(1).getFechaHasta() + "a las " + listaPromociones.get(1).getHoraHasta());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;
                case 5:
                    try {
                        TypedQuery<Promocion> query = entityManager.createQuery("SELECT p FROM Promocion p", Promocion.class);
                        List<Promocion> listaPromociones = query.getResultList();
                        Promocion promoMasBarata = listaPromociones.get(0);
                        if (promoMasBarata.getPrecioPromocional() > listaPromociones.get(2).getPrecioPromocional()) {
                            promoMasBarata = listaPromociones.get(2);
                        } else if (promoMasBarata.getPrecioPromocional() > listaPromociones.get(1).getPrecioPromocional()) {
                            promoMasBarata = listaPromociones.get(1);
                        }
                        System.out.println("-----------------PROMOCION MAS BARATA-----------------");
                        System.out.println(promoMasBarata);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                    break;
                default:
                    salir = true;
                    break;
            }

        }
        entityManager.close();
        entityManagerFactory.close();
    }
}

