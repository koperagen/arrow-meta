package arrow.meta.plugins.proofs.phases.imports

import arrow.meta.Meta
import arrow.meta.phases.ExtensionPhase
import arrow.meta.plugins.proofs.phases.ArrowProofSet
import arrow.meta.plugins.proofs.phases.ArrowRefined
import org.jetbrains.kotlin.name.FqName

val Meta.preludeImports: ExtensionPhase
  get() = extraImports { _ ->
    ArrowProofSet.map { importInfo(it) } +
      importInfo(FqName("arrow.with.n1.with")) +
      (2..22).map { importInfo(FqName("arrow.with.n$it.with$it")) } +
      importInfo(FqName("arrow.given")) +
      importInfo(ArrowRefined)
  }