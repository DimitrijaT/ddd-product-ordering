package mk.ukim.finki.emt.productcatalog.domain.models;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class ProductId extends DomainObjectId {
    public ProductId(@NonNull String uuid) {
        super(uuid);
    }


}
