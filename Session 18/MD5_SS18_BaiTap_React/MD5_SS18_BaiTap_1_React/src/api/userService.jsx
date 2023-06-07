import { instance } from "./axios"

// post user
export const REGISTER = async (newUser) => {
    await instance.post("/api/auth/signup", newUser);
}

// login
export const LOGIN = async (user) => {
    let response = await instance.post("/api/auth/signin", user);
    return response.data;
}

