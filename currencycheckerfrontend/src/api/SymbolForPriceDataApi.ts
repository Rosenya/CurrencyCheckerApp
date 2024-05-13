import axios from "axios";
import { SymbolResponse } from "../models/SymbolResponse";

export class SymbolForPriceDataApi {
    static getSymbolForPrice = async () =>
        await axios.get<SymbolResponse[]>("http://localhost:9000/{symbols}");
}