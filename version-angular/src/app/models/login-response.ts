export interface LoginResponse {
    id: number;
    email: string;
    roles: Array<string>;
    idCliente: number;
    nombre: string;
}