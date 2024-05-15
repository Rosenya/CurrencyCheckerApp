import axios from "axios";
import { Price } from "../models/Price";

export class PriceDataApi {
    static getLastPriceForGivenSymbol = async () =>
      await axios.get<Price[]>("http://localhost:3000/last/{symbol}");

    static getLastForAllSymbolsForLastDay = async () =>
        await axios.get<Price[]>("http://localhost:3000/lastday/{symbol}");

    static getLastPriceForAllSymbols = async () =>
        await axios.get<Price[]>("http://localhost:3000/lastAll");
}