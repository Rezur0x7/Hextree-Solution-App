package io.hextree.attacksurface.services;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes.dex */
public interface IFlag28Interface extends IInterface {
    public static final String DESCRIPTOR = "io.hextree.attacksurface.services.IFlag28Interface";

    /* loaded from: classes.dex */
    public static class Default implements IFlag28Interface {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // io.hextree.attacksurface.services.IFlag28Interface
        public boolean openFlag() throws RemoteException {
            return false;
        }
    }

    boolean openFlag() throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IFlag28Interface {
        static final int TRANSACTION_openFlag = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IFlag28Interface.DESCRIPTOR);
        }

        public static IFlag28Interface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IFlag28Interface.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IFlag28Interface)) {
                return (IFlag28Interface) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IFlag28Interface.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IFlag28Interface.DESCRIPTOR);
                return true;
            } else if (i == 1) {
                boolean openFlag = openFlag();
                parcel2.writeNoException();
                parcel2.writeInt(openFlag ? 1 : 0);
                return true;
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* loaded from: classes.dex */
        private static class Proxy implements IFlag28Interface {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IFlag28Interface.DESCRIPTOR;
            }

            @Override // io.hextree.attacksurface.services.IFlag28Interface
            public boolean openFlag() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IFlag28Interface.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
