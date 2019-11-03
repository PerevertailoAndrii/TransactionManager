import axios from 'axios'

const URL = "/api/transactions";

let axiosInstance = axios.create({
    timeout: 100000
});

export function fetchTransactions() {
    return axiosInstance.get(URL);
}