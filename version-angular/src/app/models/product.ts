export interface Product {
    idProducto: number;
    nombre: string;
    precio: number;
    stockAct: number;
    stockMin: number;
    stockMax: number;
    urlImagen: string;
    qty?: number;
}