import axios from "axios";
import { Price } from "../models/Price";

export class PriceDataApi {
    static getLastPriceByGivenSymbol = async () =>
      await axios.get<Price[]>("http://localhost:3000/last/{symbol}");

    static getLastDayPriceBySymbol = async () =>
        await axios.get<Price[]>("http://localhost:3000/lastday/{symbol}");

    static getLastPriceForAllSymbol = async () =>
        await axios.get<Price[]>("http://localhost:3000/lastAll");
}