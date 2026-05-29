import { useState, useEffect } from 'react';
import api from './api';
import ClienteForm from './components/ClienteForm';
import TarjetaModal from './components/TarjetaModal';
import ModificarCupoModal from './components/ModificarCupoModal';
import { Users, CreditCard, TrendingUp, Trash2, Plus } from 'lucide-react';

function App() {
  const [clientes, setClientes] = useState([]);
  const [loading, setLoading] = useState(true);
  const [tarjetaModal, setTarjetaModal] = useState({ open: false, clienteId: null });
  const [cupoModal, setCupoModal] = useState({ open: false, tarjetaNumero: null });
  const [recargar, setRecargar] = useState(0);

  useEffect(() => {
    const fetchClientes = async () => {
      try {
        const res = await api.get('/clientes');
        setClientes(res.data.data);
      } catch (error) {
        console.error(error);
      } finally {
        setLoading(false);
      }
    };
    fetchClientes();
  }, [recargar]);

  const handleRegistrarCliente = async (cliente) => {
    try {
      await api.post('/clientes', cliente);
      setRecargar(prev => prev + 1);
    } catch (error) {
      alert(error.response?.data?.error?.message || 'Error');
    }
  };

  const handleRegistrarTarjeta = async (clienteId, tarjeta) => {
    try {
      await api.post(`/clientes/${clienteId}/tarjetas`, tarjeta);
      setRecargar(prev => prev + 1);
      setTarjetaModal({ open: false, clienteId: null });
    } catch (error) {
      alert(error.response?.data?.error?.message || 'Error');
    }
  };

  const handleModificarCupo = async (numeroTarjeta, nuevoCupoTotal) => {
    try {
      await api.put(`/clientes/XXXX/tarjetas/${numeroTarjeta}/cupo-total`, null, { params: { nuevoCupoTotal } });
      setRecargar(prev => prev + 1);
      setCupoModal({ open: false, tarjetaNumero: null });
    } catch (error) {
      alert(error.response?.data?.error?.message || 'Error');
    }
  };

  const handleEliminarTarjeta = async (numeroTarjeta) => {
    if (!confirm('¿Eliminar lógicamente esta tarjeta?')) return;
    try {
      await api.delete(`/clientes/XXXX/tarjetas/${numeroTarjeta}`);
      setRecargar(prev => prev + 1);
    } catch (error) {
      alert(error.response?.data?.error?.message || 'Error');
    }
  };

  if (loading) {
    return <div className="flex justify-center items-center h-screen text-gray-500">Cargando...</div>;
  }

  return (
    <div className="min-h-screen bg-gray-50 p-6">
      <div className="max-w-7xl mx-auto">
        {/* Header */}
        <div className="mb-8">
          <h1 className="text-3xl font-bold text-gray-800">Panel de Clientes</h1>
          <p className="text-gray-500">Gestión de tarjetas de crédito</p>
        </div>

        {/* Formulario de cliente */}
        <div className="card mb-8">
          <ClienteForm onRegistrar={handleRegistrarCliente} />
        </div>

        {/* Tabla de clientes */}
        <div className="card overflow-hidden p-0">
          <div className="p-6 border-b border-gray-100">
            <div className="flex items-center gap-2">
              <Users className="text-blue-600" size={20} />
              <h2 className="text-xl font-semibold text-gray-800">Clientes</h2>
            </div>
          </div>
          <div className="overflow-x-auto">
            <table className="w-full text-sm">
              <thead className="bg-gray-50 text-gray-500">
                <tr>
                  <th className="px-6 py-3 text-left">Identificación</th>
                  <th className="px-6 py-3 text-left">Nombre</th>
                  <th className="px-6 py-3 text-left">Correo</th>
                  <th className="px-6 py-3 text-left">Tarjetas</th>
                  <th className="px-6 py-3 text-left">Acciones</th>
                </tr>
              </thead>
              <tbody className="divide-y divide-gray-100">
                {clientes.map(cliente => (
                  <tr key={cliente.numeroIdentificacion} className="hover:bg-gray-50">
                    <td className="px-6 py-4 font-mono text-gray-700">{cliente.numeroIdentificacion}</td>
                    <td className="px-6 py-4 text-gray-700">{cliente.nombreCompleto}</td>
                    <td className="px-6 py-4 text-gray-500">{cliente.correoElectronico}</td>
                    <td className="px-6 py-4">
                      <div className="space-y-2">
                        {cliente.tarjetas?.map(tarjeta => (
                          <div key={tarjeta.numero} className="bg-gray-50 rounded-lg p-2 flex justify-between items-center text-sm">
                            <div>
                              <span className="font-mono">{tarjeta.numero}</span>
                              <span className="ml-2 text-xs bg-blue-100 text-blue-700 px-2 py-0.5 rounded">{tarjeta.franquicia}</span>
                              <span className="ml-2 text-gray-500">Estado: {tarjeta.estado}</span>
                            </div>
                            <div className="flex gap-2">
                              <button onClick={() => setCupoModal({ open: true, tarjetaNumero: tarjeta.numero })} className="text-blue-600 hover:text-blue-800 text-xs flex items-center gap-1">
                                <TrendingUp size={14} /> Cupo
                              </button>
                              <button onClick={() => handleEliminarTarjeta(tarjeta.numero)} className="text-red-600 hover:text-red-800 text-xs flex items-center gap-1">
                                <Trash2 size={14} /> Eliminar
                              </button>
                            </div>
                          </div>
                        ))}
                        <button onClick={() => setTarjetaModal({ open: true, clienteId: cliente.numeroIdentificacion })} className="text-blue-600 text-sm flex items-center gap-1 mt-1 hover:underline">
                          <Plus size={14} /> Agregar tarjeta
                        </button>
                      </div>
                    </td>
                    <td className="px-6 py-4">-</td>
                  </tr>
                ))}
              </tbody>
            </table>
            {clientes.length === 0 && (
              <div className="text-center py-8 text-gray-400">No hay clientes registrados</div>
            )}
          </div>
        </div>
      </div>

      {tarjetaModal.open && (
        <TarjetaModal clienteId={tarjetaModal.clienteId} onClose={() => setTarjetaModal({ open: false, clienteId: null })} onRegistrar={handleRegistrarTarjeta} />
      )}
      {cupoModal.open && (
        <ModificarCupoModal tarjetaNumero={cupoModal.tarjetaNumero} onClose={() => setCupoModal({ open: false, tarjetaNumero: null })} onModificar={handleModificarCupo} />
      )}
    </div>
  );
}

export default App;