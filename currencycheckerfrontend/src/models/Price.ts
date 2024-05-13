import { Decimal } from 'decimal.js';

export interface Price {
  id: number;
  lastPrice: Decimal;
  timeStamp: Date;
  symbol: string;
}