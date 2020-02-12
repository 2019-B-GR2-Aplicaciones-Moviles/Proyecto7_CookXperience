/**
 * Ingrediente.js
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

    cantidad: {
      type: 'number',
      required:true
    },
    medida: {
      type: 'string',
      required:true
    },
    recetaId: {
      model: 'receta',
      required: true  }



  },

};

