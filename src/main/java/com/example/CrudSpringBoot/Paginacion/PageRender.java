package com.example.CrudSpringBoot.Paginacion;

import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

//T representa un tipo, en este caso la clase
public class PageRender<T>{

    private String url;
    private Page<T> page;
    private int totalPaginas;
    private int numElementosPorPagina;
    private int paginaActual;
    private List<PageItem> paginas;

    public PageRender(String url, Page<T> page) {
        super();
        this.url = url;
        this.page = page;
        this.paginas= new ArrayList<PageItem>();

        //Para que me muestre el maximo de paginacion que quiero, en este caso 5
        numElementosPorPagina= 4;
        totalPaginas = page.getTotalPages();
        paginaActual = page.getNumber() + 1;

        //Si la paginacion es menor a 5, corre este algoritmo para asignarle el nuevo valor
        int desde, hasta;
        if(totalPaginas <= numElementosPorPagina){
            desde = 1;
            hasta = totalPaginas;
        }else{
            if (paginaActual <= numElementosPorPagina/2) {
                desde = 1;
                hasta = numElementosPorPagina;
            }else if(paginaActual >= totalPaginas - numElementosPorPagina/2) {
                desde = totalPaginas - numElementosPorPagina+1;
                hasta = numElementosPorPagina;
            }
             else {
                 desde = paginaActual - numElementosPorPagina/2;
                 hasta = numElementosPorPagina;
            }
        }

        for(int i=0 ; i < hasta; i++){
            //Desde donde va a empezar la paginacion, hasta donde termina
            paginas.add(new PageItem(desde + i, paginaActual == desde + i));
        }

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }

    public void setTotalPaginas(int totalPaginas) {
        this.totalPaginas = totalPaginas;
    }

    public int getPaginaActual() {
        return paginaActual;
    }

    public void setPaginaActual(int paginaActual) {
        this.paginaActual = paginaActual;
    }

    public List<PageItem> getPaginas() {
        return paginas;
    }

    public void setPaginas(List<PageItem> paginas) {
        this.paginas = paginas;
    }

    public boolean isFirst(){
        return page.isFirst();
    }

    public boolean isLast(){
        return page.isLast();
    }

    public boolean isHasNext(){
        return page.hasNext();
    }

    public boolean isHasPrevius(){
        return page.hasPrevious();
    }

}
