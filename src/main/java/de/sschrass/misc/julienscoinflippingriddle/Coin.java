package de.sschrass.misc.julienscoinflippingriddle;

public class Coin {
    private CoinState coinState;

    public Coin(CoinState coinState){ this.coinState = coinState; }

    public void flip(){
        if (this.coinState.equals(CoinState.HEAD)) { this.coinState = CoinState.TAIL; }
        else { this.coinState = CoinState.HEAD; }
    }

    public CoinState getCoinState() { return this.coinState; }
    public void setCoinState(CoinState coinState) { this.coinState = coinState; }
}
