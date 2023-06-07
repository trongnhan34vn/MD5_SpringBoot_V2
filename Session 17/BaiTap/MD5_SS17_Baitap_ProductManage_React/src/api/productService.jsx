import { instance } from "./axios";


export const FIND_ALL = async () => {
    let response = await instance.get('')
    return response.data;
}

export const CREATE_PRODUCT = async (product) => {
    await instance.post("/create", product)
}

export const FIND_BY_ID = async (id) => {
    let response = await instance.get(`/findById/${id}`);
    return response.data;
}

export const DELETE = async (id) => {
    await instance.delete(`/delete/${id}`);
}

export const UPDATE = async (data) => {
    await instance.put("/edit", data);
}