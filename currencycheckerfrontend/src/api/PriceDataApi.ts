import axios from "axios";
import { Price } from "../models/Price";
import { SymbolResponse } from "../models/SymbolResponse";

export class PriceDataApi {
    static getLastPriceByGivenSymbol = async () =>
      await axios.get<Price[]>("http://localhost:3000/last/{symbol}");

    static getLastDayPriceBySymbol = async () =>
        await axios.get<Price[]>("http://localhost:3000/lastday/{symbol}");

    static getLastPriceForAllSymbol = async () =>
        await axios.get<Price[]>("http://localhost:3000/lastAll");
}