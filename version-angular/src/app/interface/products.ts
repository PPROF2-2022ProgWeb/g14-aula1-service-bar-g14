export interface Products {
    products: Product[];
}

export interface Product {
    name:        string;
    price:       number;
    thumbnail:   string;
    stock:       number;
    description: string;
    size:        string;
    vendor:      string;
    category:    string;
    id:          number;
    qty?:        number;
}
