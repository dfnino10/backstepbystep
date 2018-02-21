/*
MIT License

Copyright (c) 2017 Universidad de los Andes - ISIS2603

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.csw.bookstore.dtos;

import co.edu.uniandes.csw.bookstore.entities.BookEntity;
import co.edu.uniandes.csw.bookstore.entities.EditorialEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que extiende de {@link EditorialDTO} para manejar las relaciones entre
 * los Editorial JSON y otros DTOs. Para conocer el
 * contenido de la una Editorial vaya a la documentacion de {@link EditorialDTO}
 * @author ISIS2603
 */
public class EditorialDetailDTO extends EditorialDTO {

    /*
    * Esta lista de tipo BookDTO contiene los books que estan asociados a una editorial
    */
    private List<BookDTO> books;

    /**
     * Constructor por defecto
     */
    public EditorialDetailDTO() {
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de la editorial para transformar a DTO.
     */
    public EditorialDetailDTO(EditorialEntity entity) {
        super(entity);
        if (entity != null) {
            books = new ArrayList();
            for (BookEntity entityBook : entity.getBooks()) {
                books.add(new BookDTO(entityBook));
            }

        }
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return El DTO de la editorial para transformar a Entity
     */
    @Override
    public EditorialEntity toEntity() {
        EditorialEntity editorialE = super.toEntity();
        if (books != null) {
            List<BookEntity> booksEntity = new ArrayList();
            for (BookDTO dtoBook : books) {
                booksEntity.add(dtoBook.toEntity());
            }
            editorialE.setBooks(booksEntity);
        }
        return editorialE;
    }

    /**
     * Devuelve la lista de libros de la editorial.
     * @return the books
     */
    public List<BookDTO> getBooks() {
        return books;
    }

    /**
     * Modifica la lista de libros de la editorial.
     * @param books the books to set
     */
    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }

}
