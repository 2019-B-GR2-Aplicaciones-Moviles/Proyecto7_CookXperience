/**
 * Receta.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

    nombre: {
      type: 'string',
      required:true
    },

    tradicional: {
      type: 'boolean',
      required:true
    },

    usuarioId: {
      model: 'usuario',
      required: true  },

      ingredienteDeReceta: {     // Nombre atributo de la relación
        collection: 'ingrediente', // Nombre del modelo a relacionar
        via: 'recetaId'        // Nombre del campo a hacer la relacion
      },

      
      preparacionDeReceta: {     // Nombre atributo de la relación
        collection: 'preparacion', // Nombre del modelo a relacionar
        via: 'recetaId'        // Nombre del campo a hacer la relacion
      },

  },

};

