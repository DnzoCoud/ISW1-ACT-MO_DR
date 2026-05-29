import { useState } from 'react';
import { X } from 'lucide-react';

export default function ModificarCupoModal({ tarjetaNumero, onClose, onModificar }) {
  const [nuevoCupoTotal, setNuevoCupoTotal] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!nuevoCupoTotal || parseFloat(nuevoCupoTotal) <= 0) {
      alert('Ingrese un cupo total válido');
      return;
    }
    onModificar(tarjetaNumero, parseFloat(nuevoCupoTotal));
  };

  return (
    <div className="fixed inset-0 z-50 flex items-center justify-center bg-black/50">
      <div className="bg-white rounded-xl w-full max-w-md p-6 shadow-xl">
        <div className="flex justify-between items-center mb-4">
          <h2 className="text-xl font-bold text-gray-800">Modificar cupo total</h2>
          <button onClick={onClose} className="text-gray-400 hover:text-gray-600">
            <X size={20} />
          </button>
        </div>
        <form onSubmit={handleSubmit} className="space-y-4">
          <input
            type="number"
            step="any"
            placeholder="Nuevo cupo total"
            value={nuevoCupoTotal}
            onChange={(e) => setNuevoCupoTotal(e.target.value)}
            className="input"
          />
          <div className="flex justify-end gap-3 pt-2">
            <button type="button" onClick={onClose} className="btn-secondary">
              Cancelar
            </button>
            <button type="submit" className="btn-primary">
              Actualizar cupo
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}