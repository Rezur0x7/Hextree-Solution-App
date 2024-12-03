package io.hextree.attacksurface.services;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes.dex */
public interface IFlag29Interface extends IInterface {
    public static final String DESCRIPTOR = "io.hextree.attacksurface.services.IFlag29Interface";

    /* loaded from: classes.dex */
    public static class Default implements IFlag29Interface {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // io.hextree.attacksurface.services.IFlag29Interface
        public void authenticate(String str) throws RemoteException {
        }

        @Override // io.hextree.attacksurface.services.IFlag29Interface
        public String init() throws RemoteException {
            return null;
        }

        @Override // io.hextree.attacksurface.services.IFlag29Interface
        public void success() throws RemoteException {
        }
    }

    void authenticate(String str) throws RemoteException;

    String init() throws RemoteException;

    void success() throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IFlag29Interface {
        static final int TRANSACTION_authenticate = 2;
        static final int TRANSACTION_init = 1;
        static final int TRANSACTION_success = 3;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IFlag29Interface.DESCRIPTOR);
        }

        public static IFlag29Interface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IFlag29Interface.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IFlag29Interface)) {
                return (IFlag29Interface) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IFlag29Interface.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IFlag29Interface.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                String init = init();
                parcel2.writeNoException();
                parcel2.writeString(init);
            } else if (i == 2) {
                authenticate(parcel.readString());
                parcel2.writeNoException();
            } else if (i == 3) {
                success();
                parcel2.writeNoException();
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        /* loaded from: classes.dex */
        private static class Proxy implements IFlag29Interface {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IFlag29Interface.DESCRIPTOR;
            }

            @Override // io.hextree.attacksurface.services.IFlag29Interface
            public String init() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IFlag29Interface.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // io.hextree.attacksurface.services.IFlag29Interface
            public void authenticate(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IFlag29Interface.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // io.hextree.attacksurface.services.IFlag29Interface
            public void success() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IFlag29Interface.DESCRIPTOR);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
