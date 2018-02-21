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

import java.util.Date;

/**
 * BookDTO Objeto de transferencia de datos de Editoriales. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 *
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number,
 *      "name: string,
 *      "isbn": string,
 *      "image: string,
 *      "description": string,
 *      "publishingdate": string
 *   }
 * </pre>
 * Por ejemplo una editorial se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "id": 125126,
 *      "name: "Libro interesante",
 *      "isbn": "979-3-16-11235-0",
 *      "image: "/images/book.jpg",
 *      "description": "Este libro se trata sobre ejemplos de JSON en API REST",
 *      "publishingdate": "2018-02-12"
 *   }
 *
 * </pre>
 * @author ISIS2603
 */
public class BookDTO {

    private Long id;
    private String name;
    private String isbn;
    private String image;
    private String description;
    private Date publishingdate;

    /**
     * Constructor por defecto
     */
    public BookDTO() {
    }

    /**
     * Constructor a partir de la entidad
     * @param bookE  La entidad del libro
     */
    public BookDTO(BookEntity bookE) {
        if (bookE != null) {
            this.id = bookE.getId();
            this.name = bookE.getName();
            this.isbn = bookE.getIsbn();
            this.image = bookE.getImage();
            this.description = bookE.getDescription();
            this.publishingdate = bookE.getPublishDate();
        }
    }

    /**
     * Método para transformar el DTO a una entidad.
     * @return La entidad del libro asociado.
     */
    public BookEntity toEntity() {

        BookEntity bookE = new BookEntity();
        bookE.setId(this.id);
        bookE.setName(this.name);
        bookE.setIsbn(this.isbn);
        bookE.setImage(this.image);
        bookE.setDescription(this.description);
        bookE.setPublishDate(this.publishingdate);

        return bookE;
    }

    /**
     * Devuelve el ID del libro
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica el ID del libro.
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre del libro.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica el nombre del libro.
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Devuelve el ISBN del libro.
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Modifica el ISBN del libro.
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Devuelve la imagen del libro.
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * Modifica la imagen del libro.
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Devuelve la descripción del libro.
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Modifica la descripción del libro.
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Devuelve la fecha de publicación del libro.
     * @return the publishingdate
     */
    public Date getPublishingdate() {
        return publishingdate;
    }

    /**
     * Modifica la fecha de publicación del libro.
     * @param publishingdate the publishingdate to set
     */
    public void setPublishingdate(Date publishingdate) {
        this.publishingdate = publishingdate;
    }

}
