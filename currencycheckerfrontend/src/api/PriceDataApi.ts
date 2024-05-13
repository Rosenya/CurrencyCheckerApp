import axios from "axios";
import { Price } from "../models/Price";
import { SymbolResponse } from "../models/SymbolResponse";

export class PriceDataApi {
    static getLastPriceBySymbol = async () =>
      await axios.get<Price[]>("http://localhost:9000/last/{symbol}");

    static getSymbolForPrize = async () =>
      await axios.get<SymbolResponse[]>("http://localhost:9000/{symbols}");

    static getLastDayPriceBySymbol = async () =>
        await axios.get<Price[]>("http://localhost:9000/lastday/{symbol}");

    static getLastPriceForAllSymbol = async () =>
        await axios.get<Price[]>("http://localhost:9000/lastAll");
}