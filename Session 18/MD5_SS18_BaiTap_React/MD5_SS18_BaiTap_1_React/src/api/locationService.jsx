import { instance } from "./axios"

export const FIND_ALL_LOCATION = async () => {
    let response = await instance.get('/api/register')
    return response.data;
}