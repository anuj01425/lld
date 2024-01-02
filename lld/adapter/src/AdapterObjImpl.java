public class AdapterObjImpl implements SocketAdapter {

    private Socket socket = new Socket();

    @Override
    public Volt volt120(){
        return convertToVolt(socket.getVolt(), 40);
    }

    @Override
    public Volt volt12() {
        return convertToVolt(socket.getVolt(), 12);

    }

    @Override
    public Volt volt3() {
        return convertToVolt(socket.getVolt(), 3);
    }

    private Volt convertToVolt(Volt v, int i){
        return new Volt(v.getVolts()/i);
    }
}
