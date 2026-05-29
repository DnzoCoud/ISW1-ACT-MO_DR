import { useState } from 'react';
import { X } from 'lucide-react';

export default function TarjetaModal({ clienteId, onClose, onRegistrar }) {
  const [form, setForm] = useState({
    numero: '',
    fechaVencimiento: '',
    cupoTotal: '',
    cupoDisponible: ''
  });

  const handleChange = (e) => setForm({ ...form, [e.target.name]: e.target.value });

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!form.numero || !form.fechaVencimiento || !form.cupoTotal || !form.cupoDisponible) {
      alert('Complete todos los campos');
      return;
    }
    const tarjeta = {
      numero: form.numero,
      fechaVencimiento: form.fechaVencimiento,
      cupoTotal: parseFloat(form.cupoTotal),
      cupoDisponible: parseFloat(form.cupoDisponible)
    };
    onRegistrar(clienteId, tarjeta);
  };

  return (
    <div className="fixed inset-0 z-50 flex items-center justify-center bg-black/50">
      <div className="bg-white rounded-xl w-full max-w-md p-6 shadow-xl">
        <div className="flex justify-between items-center mb-4">
          <h2 className="text-xl font-bold text-gray-800">Registrar tarjeta</h2>
          <button onClick={onClose} className="text-gray-400 hover:text-gray-600">
            <X size={20} />
          </button>
        </div>
        <form onSubmit={handleSubmit} className="space-y-4">
          <input
            name="numero"
            placeholder="Número de tarjeta"
            value={form.numero}
            onChange={handleChange}
            className="input"
          />
          <input
            name="fechaVencimiento"
            placeholder="MM/YYYY"
            value={form.fechaVencimiento}
            onChange={handleChange}
            className="input"
          />
          <input
            name="cupoTotal"
            type="number"
            step="any"
            placeholder="Cupo total"
            value={form.cupoTotal}
            onChange={handleChange}
            className="input"
          />
          <input
            name="cupoDisponible"
            type="number"
            step="any"
            placeholder="Cupo disponible"
            value={form.cupoDisponible}
            onChange={handleChange}
            className="input"
          />
          <div className="flex justify-end gap-3 pt-2">
            <button type="button" onClick={onClose} className="btn-secondary">
              Cancelar
            </button>
            <button type="submit" className="btn-primary">
              Guardar tarjeta
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}