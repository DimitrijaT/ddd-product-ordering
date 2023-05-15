package mk.ukim.finki.emt.sharedkernel.domain.base;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractEntity <ID extends DomainObjectId> {

    // Ако сакаме да кажеме дека користиме композитен клуч, тогаш ќе го користиме @EmbeddedId
    // т.е. поле кое содржи повеќе од еден атрибут
    // Тука не е примитивен бидејќи е класа
    @EmbeddedId
    private ID id;
}



