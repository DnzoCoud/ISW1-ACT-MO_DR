import { useState } from 'react';
import { UserPlus } from 'lucide-react';

export default function ClienteForm({ onRegistrar }) {
  const [form, setForm] = useState({
    numeroIdentificacion: '',
    primerNombre: '',
    segundoNombre: '',
    primerApellido: '',
    segundoApellido: '',
    correoElectronico: ''
  });

  const handleChange = (e) => setForm({ ...form, [e.target.name]: e.target.value });

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!form.numeroIdentificacion || !form.primerNombre || !form.primerApellido || !form.correoElectronico) {
      alert('Complete los campos obligatorios');
      return;
    }
    onRegistrar(form);
    setForm({
      numeroIdentificacion: '',
      primerNombre: '',
      segundoNombre: '',
      primerApellido: '',
      segundoApellido: '',
      correoElectronico: ''
    });
  };

  return (
    <div>
      <div className="flex items-center gap-2 mb-4">
        <UserPlus className="text-blue-600" size={20} />
        <h2 className="text-lg font-semibold text-gray-800">Registrar nuevo cliente</h2>
      </div>
      <form onSubmit={handleSubmit} className="grid grid-cols-1 md:grid-cols-3 gap-4">
        <input type="text" name="numeroIdentificacion" placeholder="Identificación *" value={form.numeroIdentificacion} onChange={handleChange} className="input" />
        <input type="text" name="primerNombre" placeholder="Primer nombre *" value={form.primerNombre} onChange={handleChange} className="input" />
        <input type="text" name="segundoNombre" placeholder="Segundo nombre" value={form.segundoNombre} onChange={handleChange} className="input" />
        <input type="text" name="primerApellido" placeholder="Primer apellido *" value={form.primerApellido} onChange={handleChange} className="input" />
        <input type="text" name="segundoApellido" placeholder="Segundo apellido" value={form.segundoApellido} onChange={handleChange} className="input" />
        <input type="email" name="correoElectronico" placeholder="Correo *" value={form.correoElectronico} onChange={handleChange} className="input" />
        <div className="md:col-span-3 flex justify-end">
          <button type="submit" className="btn-primary">Guardar cliente</button>
        </div>
      </form>
    </div>
  );
}