import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICalculadora extends Remote{

	public int calcular(int a, int b, int op) throws RemoteException;

}
